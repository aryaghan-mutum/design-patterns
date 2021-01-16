package com.designpatterns.dao.example1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Books {

    private String isbn;
    private String author;
    private String bookName;
}
