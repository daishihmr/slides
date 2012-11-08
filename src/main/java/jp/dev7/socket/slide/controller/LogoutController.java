package jp.dev7.socket.slide.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.users.UserServiceFactory;

public class LogoutController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return redirect(UserServiceFactory.getUserService().createLogoutURL("/"));
    }
}
