package com.company.app.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final String status;
    private final T data;
    private final Meta meta;

    @Getter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Meta {
        private final String timestamp;
        private final Pagination pagination;
    }

    @Getter
    @Builder
    public static class Pagination {
        private final int page;
        private final int size;
        private final long totalElements;
        private final int totalPages;
    }

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
            .status("success")
            .data(data)
            .meta(Meta.builder()
                .timestamp(Instant.now().toString())
                .build())
            .build();
    }

    public static <T> ApiResponse<T> success(T data, Pagination pagination) {
        return ApiResponse.<T>builder()
            .status("success")
            .data(data)
            .meta(Meta.builder()
                .timestamp(Instant.now().toString())
                .pagination(pagination)
                .build())
            .build();
    }
}
