package com.github.xuzw.forexroo_quoted_price_api.api;

import com.github.xuzw.api_engine_runtime.api.Api;
import com.github.xuzw.api_engine_runtime.api.Request;
import com.github.xuzw.api_engine_runtime.api.Response;
import com.github.xuzw.api_engine_sdk.annotation.GenerateByApiEngineSdk;
import com.github.xuzw.forexroo_quoted_price_api.service.QuotedPriceService;
import com.github.xuzw.modeler_runtime.annotation.Comment;
import com.github.xuzw.modeler_runtime.annotation.Required;

@Comment(value = "实时报价 - 查询")
@GenerateByApiEngineSdk(time = "2017.06.22 01:27:57.570", version = "v0.0.1")
public class QuotedPrice_Query_Api implements Api {

    @Override()
    public Response execute(Request request) throws Exception {
        Req req = (Req) request;
        Resp resp = new Resp();
        resp.setBid(QuotedPriceService.getBidIfPresent(req.getSymbol()));
        return resp;
    }

    public static class Req extends Request {

        @Comment(value = "品种") @Required(value = true) private String symbol;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

    public static class Resp extends Response {

        @Comment(value = "买入价") @Required(value = true) private String bid;

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }
    }
}
