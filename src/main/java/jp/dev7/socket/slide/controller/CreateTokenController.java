package jp.dev7.socket.slide.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;

public class CreateTokenController extends Controller {

    @Override
    public Navigation run() throws Exception {
        final ChannelService channelService = ChannelServiceFactory
                .getChannelService();
        String token = channelService.createChannel(param("key"));
        response.setContentType("text/plain");
        response.getWriter().print(token);
        response.flushBuffer();
        return null;
    }
}
