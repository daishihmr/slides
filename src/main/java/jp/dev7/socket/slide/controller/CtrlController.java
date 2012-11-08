package jp.dev7.socket.slide.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class CtrlController extends Controller {

    @Override
    public Navigation run() throws Exception {
        final UserService userService = UserServiceFactory.getUserService();
        if (userService.getCurrentUser() == null || !userService.isUserLoggedIn()) {
            return redirect(userService.createLoginURL("/ctrl"));
        }

        return forward("controller.html");
    }
}
