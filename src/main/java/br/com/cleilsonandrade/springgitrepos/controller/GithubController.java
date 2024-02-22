package br.com.cleilsonandrade.springgitrepos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repos")
public class GithubController {
  @GetMapping
  public ResponseEntity<List<RepositoryResponse>> listRepos() {
    return null;
  }
}
