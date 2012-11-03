package jp.dev7.socket.slide.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

public class SendMessageController extends Controller {

    @Override
    public Navigation run() throws Exception {
        System.out.println(param("data"));

        ChannelService channelService = ChannelServiceFactory
                .getChannelService();
        channelService.sendMessage(new ChannelMessage(param("to"),
                param("data")));
        return null;
    }
}
