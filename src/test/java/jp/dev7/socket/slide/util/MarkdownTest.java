package jp.dev7.socket.slide.util;

import org.junit.Test;

import com.petebevin.markdown.MarkdownProcessor;

public class MarkdownTest {

    @Test
    public void testMarkdownj() {
        String src = "こんにちは\n" + "==========";
        MarkdownProcessor md = new MarkdownProcessor();
        String dist = md.markdown(src);
        System.out.println(dist);
    }

}
