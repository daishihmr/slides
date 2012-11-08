package jp.dev7.socket.slide.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class SendMessageController extends Controller {

    @Override
    public Navigation run() throws Exception {
        final UserService userService = UserServiceFactory.getUserService();
        if (userService.getCurrentUser() == null || !userService.isUserLoggedIn() || !userService.isUserAdmin()) {
            return null;
        }

        ChannelService channelService = ChannelServiceFactory.getChannelService();
        channelService.sendMessage(new ChannelMessage(param("to"), param("data")));
        return null;
    }
}
