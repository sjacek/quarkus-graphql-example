package com.github.sjacek.graphql.api;

import com.github.sjacek.graphql.dto.SearchResult;
import com.github.sjacek.graphql.service.SearchService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class SearchResource {

    private final SearchService searchService;

    private SearchResource(SearchService searchService) {
        this.searchService = searchService;
    }

    @Query
    @Description("Search for books and authors")
    public List<SearchResult> search(@Description("Search term") String term) {
        // This is a placeholder implementation. In a real application, you would implement the search logic here.
        return this.searchService.search(term);
    }
}
