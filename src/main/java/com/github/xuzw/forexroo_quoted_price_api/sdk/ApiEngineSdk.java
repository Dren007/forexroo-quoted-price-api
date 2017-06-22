package com.github.xuzw.forexroo_quoted_price_api.sdk;

import java.io.IOException;

import com.github.xuzw.api_engine_sdk.model.EngineDefinition;
import com.github.xuzw.api_engine_sdk.utils.ApiDocumentUtils;
import com.github.xuzw.api_engine_sdk.utils.ApiEngineGeneratorUtils;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月25日 上午11:49:45
 */
public class ApiEngineSdk {
    public static void main(String[] args) throws IOException {
        String srcFolder = "src/main/java";
        EngineDefinition engineDefinition = ApiEngineGeneratorUtils.buildEngineDefinition("design/api.json");
        ApiEngineGeneratorUtils.updateApiJavaFiles(srcFolder, engineDefinition);
        ApiEngineGeneratorUtils.deleteUnusedApiJavaFiles(srcFolder, engineDefinition);
        ApiEngineGeneratorUtils.updateErrorCodeJavaFile(srcFolder, engineDefinition);
        ApiDocumentUtils.writeApiHtmlDocumentFile("doc", engineDefinition);
        ApiEngineGeneratorUtils.deleteModelJavaFiles(srcFolder, engineDefinition);
        ApiEngineGeneratorUtils.createModelJavaFiles(srcFolder, engineDefinition);
        System.out.println("done.");
    }
}
