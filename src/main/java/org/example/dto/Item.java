package org.example.dto;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class Item {
    String name;
    String price;
    String description;

}
