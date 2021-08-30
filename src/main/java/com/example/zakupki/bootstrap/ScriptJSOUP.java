package com.example.zakupki.bootstrap;


import com.example.zakupki.repositories.OrganisationRepo;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptJobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class ScriptJSOUP implements CommandLineRunner {
    @Autowired
    private OrganisationRepo organisationRepo;

    @Override
    public void run(String... args) throws Exception {
        int page = 0;
//        Document document = Jsoup.connect("http://zakupki.gov.kg/popp/view/services/registry/procurementEntities.xhtml").get();
//        Element table = document.getElementById("table");
//        Elements tbody = table.select("tbody");
//        Elements trs = tbody.select("tr");

        final WebClient webClient = new WebClient();
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);

        final URL url = new URL("http://zakupki.gov.kg/popp/view/services/registry/procurementEntities.xhtml");
        final HtmlPage mainPage = (HtmlPage) webClient.getPage(url);
        DomElement domElement = mainPage.getElementById("table");
        HtmlElement tbody = domElement.getElementsByTagName("tbody").get(0);
        tbody.asText();
        for(HtmlElement tr : tbody.getElementsByTagName("tr")){
            for(HtmlElement td : tr.getElementsByTagName("td")){
                if(td.getElementsByTagName("a").size() > 0){
                    HtmlAnchor htmlAnchor = mainPage.getAnchorByText(td.getElementsByTagName("a").get(0).asText());
                    System.out.println(htmlAnchor);
                    HtmlPage morePage = htmlAnchor.click();
//                    DomElement moreBody = morePage.getElementsByTagName("tbody").get(0);
                    System.out.println(morePage.asText());
                }
            }
        }

    }
}
