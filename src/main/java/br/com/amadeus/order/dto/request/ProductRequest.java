package br.com.amadeus.order.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {

    private String name;
    private Double value;
}
