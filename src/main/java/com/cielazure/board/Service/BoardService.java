package com.cielazure.board.Service;

import com.cielazure.board.Model.Board;
import com.cielazure.board.Model.User;
import com.cielazure.board.Repository.BoardRepository;
import com.cielazure.board.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board) {
        User user = userRepository.findByName(username).get(0);
        board.setUser(user);
        return boardRepository.save(board);
    }
}
