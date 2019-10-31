package org.zhxie.sprintpoker.config.interceptors;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zhxie.sprintpoker.entity.Room;
import org.zhxie.sprintpoker.entity.dto.ResponseResult;
import org.zhxie.sprintpoker.repository.SocketSessionRegistry;
import org.zhxie.sprintpoker.util.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class CheckRoomPasswordIntercepter extends HandlerInterceptorAdapter {

    @Autowired
    SocketSessionRegistry webAgentSessionRegistry;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String roomName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        String cookieKey = "roomPassword_".concat(roomName);
        String roomPassword = CookieUtil.extractCookie(request, cookieKey);
        Optional<Room> findRoom = webAgentSessionRegistry.getRooms().stream().filter(roomItem -> (roomItem.getName().equals(roomName) && (roomItem.getRoomPassword().equals(roomPassword)))).findAny();
        if(findRoom.isPresent()) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath()+"/rooms");
            return false;
        }
    }
}