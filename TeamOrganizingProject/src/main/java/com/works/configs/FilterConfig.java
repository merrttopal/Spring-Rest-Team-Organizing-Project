package com.works.configs;


import com.works.entities.Footbollers;
import com.works.service.FootbollerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Configuration
@RequiredArgsConstructor
public class FilterConfig implements Filter {

    final FootbollerService footbollerService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        String freeUrls[] = {"/footboller/register","/footboller/login","/teams/list","/teams/backUpCreate"};

        boolean loginStatus = true;
        for(String item : freeUrls){
            if(url.equals(item)){
                loginStatus = false;
                break;
            }
        }
        if(loginStatus){
            boolean status = req.getSession().getAttribute("footbollers") == null;
            if(status){
                PrintWriter printWriter = res.getWriter();
                printWriter.println("{ \"status\": false, \"result\": \"Plase Login\" }");
                res.setContentType("application/json");
                res.setStatus(401);
            }else{
                Footbollers footbollers = (Footbollers) req.getSession().getAttribute("footbollers");
                req.setAttribute("footbollers", footbollers);
                filterChain.doFilter(req,res);
            }
        }
        else {
            filterChain.doFilter(req,res);
        }
    }
}