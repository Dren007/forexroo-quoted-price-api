package com.github.xuzw.forexroo_quoted_price_api.api;

import com.github.xuzw.api_engine_runtime.api.ResponseCode;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;

@GenerateByApiEngineSdk(time = "2017.06.22 01:27:57.716", version = "v0.0.1")
public enum ErrorCodeEnum implements ResponseCode {

    /**MT4中间件错误*/
    mt4_middleware_error(1012, "MT4中间件错误");

    private ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;

    public int getCode() {
        return code;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
