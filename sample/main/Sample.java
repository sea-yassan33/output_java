package main;

import java.util.Objects;

public class Sample {
	
	// 1.privateインスタンス変数
	private String strValue = null;
	
	// 2.privateクラス変数 
    private static String strValueStatic = null;

    private InnerDynamic innerDynamic = null;

    private static InnerStatic innerStatic = new InnerStatic();

    
    public String getStrValue() {
        return this.strValue;
    }

    public static String getStrValueStatic() {
        return strValueStatic;
    }

    public String getDynamicInnerPrivate() {
        if (Objects.isNull(this.innerDynamic)) {
            this.innerDynamic = new InnerDynamic();
        }
        return this.innerDynamic.getIStrValue();
    }

    public static String getStaticInnerPrivate() {
        return innerStatic.getIStrValue();
    }

    //3.動的privateクラスのインスタンス変数
    private class InnerDynamic {
        private String iStrValue = null;

        public String getIStrValue() {
            return this.iStrValue;
        }
    }

    //4.静的privateクラスのインスタンス変数
    private static class InnerStatic {
        private String iStrValue = null;

        public String getIStrValue() {
            return this.iStrValue;
        }
    }

}
