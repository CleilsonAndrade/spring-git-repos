package br.com.cleilsonandrade.springgitrepos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cleilsonandrade.springgitrepos.api.GithubClient;

@RestController
@RequestMapping("/repos")
public class GithubController {
  @Autowired
  private GithubClient githubClient;

  @GetMapping
  public ResponseEntity<List<RepositoryResponse>> listRepos(@RequestHeader("token") String token) {
    var repos = githubClient.listRepos("Bearer " + token, null, "public");

    return ResponseEntity.ok(repos);
  }
}
