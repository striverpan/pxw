import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pan on 2017/9/6.
 */
public class Test {

    public static void main(String[] args) {


        Logger logger = LoggerFactory.getLogger(Test.class);
        // 输出字符串
        System.out.println("xxx");
        logger.error("this is a error msg",new NullPointerException());
        logger.error("this is a error msg",new NullPointerException());
        logger.error("this is a error msg",new NullPointerException());
        logger.info("this is a error msg",new NullPointerException());
        String s= null;
        s.charAt(1);
    }
}
