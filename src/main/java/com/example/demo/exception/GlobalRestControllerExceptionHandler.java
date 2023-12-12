package com.example.demo.exception;

import com.example.demo.model.CustomParams;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Enumeration;
import java.util.StringJoiner;

@RestControllerAdvice
public class GlobalRestControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex, HttpServletRequest request) {
        //String requestURL = request.getRequestURL().toString();
        /*Enumeration<String> parameterNames = request.getParameterNames();
        StringBuilder requestParameters = new StringBuilder();
        requestParameters.append("{");
        while(parameterNames.hasMoreElements()) {
            String parameter = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(parameter);
            StringBuilder value = new StringBuilder();
            for (String v:parameterValues) {
                value.append(v);
            }
            requestParameters.append(parameter + " : " + value + ", ");
        }
        requestParameters.append("}");*/
        String[] param1Values = request.getParameterValues("param1");
        StringJoiner joiner = new StringJoiner(" ");
        for (String s : param1Values) {
            joiner.add(s);
        }

        System.out.println(joiner);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

}
