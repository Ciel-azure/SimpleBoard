package com.cielazure.board.Controller;

import com.cielazure.board.Model.Board;
import com.cielazure.board.Repository.BoardRepository;
import com.cielazure.board.Validator.BoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardValidator boardValidator;

    @GetMapping("list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {
        if(id == null) {
            model.addAttribute("board", new Board());
        } else {
            model.addAttribute("board", boardRepository.findById(id));
        }
        return "board/form";
    }

    @PostMapping("/form")
    public String postForm(@Valid Board board, BindingResult result) {
        boardValidator.validate(board, result);
        if (result.hasErrors()) {
            return "board/form";
        }
        boardRepository.save(board);
        return "redirect:/board/list";
    }
}
