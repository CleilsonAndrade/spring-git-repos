package br.com.cleilsonandrade.springgitrepos.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class GithubClientConfig {

  @Value("${github.api.base-url}")
  private String baseUrl;

  @Bean
  public HttpServiceProxyFactory httpServiceProxyFactory() {
    WebClient webClient = WebClient.builder()
        .baseUrl(baseUrl)
        .build();

    return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
  }

  @Bean
  public GithubClient githubClient(HttpServiceProxyFactory factory) {
    return factory.createClient(GithubClient.class);
  }
}
