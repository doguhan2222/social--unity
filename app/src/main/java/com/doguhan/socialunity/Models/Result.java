package com.doguhan.socialunity.Models;

import com.google.gson.annotations.SerializedName;

public class Result {

 private String Result;

    // kayıt olunduğunda gelen responsu döndüren model class

    public Result(String result) {
        Result = result;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "Result='" + Result + '\'' +
                '}';
    }
}
