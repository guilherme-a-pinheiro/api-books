package com.pinheiro.Books.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("Name")
    private String name;

    @JsonProperty("PublisherTime")
    private String publishedTime;

    @JsonProperty("Author")
    private String author;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Price")
    private Double price;
}
