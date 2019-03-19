package com.idukelu.demo.demotxlcnbankb.business.pojo.bo;

import lombok.Data;

@Data
public class Result<T> {

    private String status;

    private T value;

    private Integer total;

    private Result() {}

    private Result(String status, T value) {
        this.status = status;
        this.value = value;
    }

    private Result(String status, T value, int total) {
        this.status = status;
        this.value = value;
        this.total = total;
    }

    public static <T> Result success(T value) {
        return new Result<>("success", value);
    }

    public static <T> Result failure(T value) {
        return new Result<>("failure", value);
    }

    public static <T> Result success(T value, Integer total) {
        return new Result<>("success", value, total);
    }

    public static <T> Result failure(T value, Integer total) {
        return new Result<>("failure", value, total);
    }
}
