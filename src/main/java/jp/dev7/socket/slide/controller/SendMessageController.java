package jp.dev7.socket.slide.controller;

import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class SendMessageController extends Controller {

    private static Logger LOG = Logger.getLogger(SendMessageController.class.getName());

    @Override
    public Navigation run() throws Exception {
        final UserService userService = UserServiceFactory.getUserService();
        if (userService.getCurrentUser() == null || !userService.isUserLoggedIn() || !userService.isUserAdmin()) {
            response.sendError(401);
            return null;
        }

        LOG.info(userService.getCurrentUser().getUserId() + " : send [" + param("data") + "] to [" + param("to") + "]");

        ChannelService channelService = ChannelServiceFactory.getChannelService();
        channelService.sendMessage(new ChannelMessage(param("to"), param("data")));
        return null;
    }
}
