package microservices.book.gateway.fallback;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GatewayClientResponse implements ClientHttpResponse {

    private final HttpStatus httpStatus;
    private final MediaType mediaType;
    private final String body;


    public GatewayClientResponse(HttpStatus httpStatus, MediaType mediaType, String body) {
        this.httpStatus = httpStatus;
        this.mediaType = mediaType;
        this.body = body;
    }

    @Override
    public HttpStatus getStatusCode() throws IOException {
        return httpStatus;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return httpStatus.value();
    }

    @Override
    public String getStatusText() throws IOException {
        return httpStatus.toString();
    }

    @Override
    public void close() {

    }

    @Override
    public InputStream getBody() throws IOException {
        return new ByteArrayInputStream(body.getBytes());
    }

    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        headers.setAccessControlAllowCredentials(true);
        headers.setAccessControlAllowOrigin("*");
        return headers;
    }
}
