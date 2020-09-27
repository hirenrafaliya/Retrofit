package com.akx.retrofit.model;

import java.util.List;

public class Quotes
{
    private String source;

    private List<String> quotes;



    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return this.source;
    }
    public void setQuotes(List<String> quotes){
        this.quotes = quotes;
    }
    public List<String> getQuotes(){
        return this.quotes;
    }
}