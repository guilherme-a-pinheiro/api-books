package com.pinheiro.Books.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BookRequestDTO(

        @JsonProperty("Name")
        String name,

        @JsonProperty("PublisherTime")
        String publishedTime,

        @JsonProperty("Author")
        String author,

        @JsonProperty("Description")
        String description,

        @JsonProperty("Price")
        Double price
) {
}
