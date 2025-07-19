package com.graph.graph.common;

//同一包装返回类

public class Result {
    public int code;
    public String msg;
    public Object data;

    public Result() {
    }

    public static Result sucess(){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("请求成功");
        return result;
    }

    public static Result sucess(Object data){
        Result result = sucess();
        result.setData(data);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(500);
        result.setMsg("请求失败");
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
