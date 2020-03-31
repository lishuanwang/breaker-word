package cn.thk.constants;

public enum SystemMsgEnum {

    // 系统的入口
    SYSTEM_COMMAND_MSG("请输入你需要分词的类型 \n" +
            " 1\t使用系统字典分词 \n " +
            "2 \t使用用户定义字典分词 \n " +
            "3 \t使用用户字典以及系统字段分词 \n" +
            " 4 \t退出系统"),
    // 系统的指令错误
    SYSTEM_COMMAND_ERROR("您输入的指令有错误，请输入1-4的整数"),
    // 用户分词内容输入提示
    USER_BREAKER_MSG("请输入您的分词内容"),
    // 用户选择分词指令错误提示
    BREAK_COMMAND_ERROR("您输入的指令有误");

    private String msg;

    SystemMsgEnum(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
