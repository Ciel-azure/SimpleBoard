package com.cielazure.board.Validator;

import com.cielazure.board.Model.Board;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class BoardValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors e) {
        Board board = (Board) object;
        if(StringUtils.isEmpty(board.getContent())) {
            e.rejectValue("content", "key","내용을 입력하세요");
        }

    }
}
