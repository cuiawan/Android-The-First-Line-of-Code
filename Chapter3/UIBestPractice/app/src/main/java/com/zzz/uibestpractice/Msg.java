package com.zzz.uibestpractice;

public class Msg {

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;
    //表示消息内容
    private String content;
    //表示消息类型
    //其中type有两个值可选，TYPE_RECEIVED，TYPE_SEND
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
