package com.github.xuzw.forexroo_quoted_price_api.engine;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.github.xuzw.api_engine_runtime_http_wrapper.ApiEngineRuntimeHttpWrapper;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月7日 下午6:45:41
 */
@WebFilter(urlPatterns = "/*", initParams = @WebInitParam(name = ApiEngineRuntimeHttpWrapper.init_param_name_auto_scan_package, value = "com.github.xuzw.forexroo_quoted_price_api.api"))
public class ApiFilter extends ApiEngineRuntimeHttpWrapper {
}
