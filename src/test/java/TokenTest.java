import com.google.gson.Gson;
import org.loglang.filter.FilterNode;
import org.loglang.util.PropertyReader;

import java.io.IOException;

/**
 * Created by liumiao on 16-5-14.
 */
public class TokenTest {

    public static void main(String[] args) throws IOException {
        PropertyReader reader = new PropertyReader("conf/tokens.properties");
        String log = reader.get("test");
        String regex = reader.get("test.regex");
        Gson gson = new Gson();
        FilterNode node = gson.fromJson(regex, FilterNode.class);
        System.out.println(node.valid(log));
    }
}
