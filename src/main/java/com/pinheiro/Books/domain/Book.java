package com.pinheiro.Books.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String publishedTime;
    private String author;
    private String description;
    private Double price;
}
