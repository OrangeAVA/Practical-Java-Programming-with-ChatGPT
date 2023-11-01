package com.asb;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
public class ChatGPTApi {
    private static final String API_KEY = "sk-xxxxxxxxxxxxxxxxxxxxxxBlbkFJVAIxxxxxxxxxxxxxxxxx";
    private static final String MODEL_ID = "\"gpt-3.5-turbo\"";
/*
 * ASB Software Development Addition and URL change we know the following URL works:
 * 
 * https://api.openai.com/v1/chat/completions -H "Authorization: Bearer sk-xxxxxxxxxxxxxxxxxxxxxxBlbkFJVAIxxxxxxxxxxxxxxxxx" -H "Content-Type: application/json" -d '{"model": "gpt-3.5-turbo", "messages": [{"role": "user", "content": "What is the OpenAI mission?"}] }'
 * 
 */
// Original    private static final String API_URL = "https://api.openai.com/v1/engines/" + MODEL_ID + "/completions";
// NEW    private static final String API_URL = "https://api.openai.com/v1/chat/completions/";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    public static String getResponseFromGPT(String prompt) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        // ASB Original line gave the error "message": "you must provide a model parameter",
        //RequestBody body = RequestBody.create(mediaType, "{  \"prompt\": \"" + prompt + "\",\"temperature\":0.7,\"max_tokens\":60}");
        RequestBody body = RequestBody.create(mediaType, "{  \"\"model\"\":  \"" + MODEL_ID + "\",\"messages\": [{\"role\": \"user\", \"content\":" + prompt + "\",\"temperature\":0.7,\"max_tokens\":60}");
        Request request = new Request.Builder()
                .url(API_URL)
                .method("POST", body)
                .addHeader("Authorization", " Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .addHeader("messages", " [{\"role\": \"user\", \"content\": \"What is the OpenAI mission?\" }") //}]
                .build(); 
        System.out.print("Request=" + request.toString());
        Response response = client.newCall(request).execute();
        String responseJson = response.body().string();
        response.close();
        return responseJson;
    }

    public static void main(String[] args) throws Exception {
        String responseJson = getResponseFromGPT("Hello, how are you?");
        System.out.println(responseJson);
    }
}

