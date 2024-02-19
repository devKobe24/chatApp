package com.devkobe24.chatApp.domain;

import com.devkobe24.chatApp.domain.ChatDTO.MessageType;
import com.devkobe24.chatApp.service.ChatService;
import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

@Data
public class ChatRoom {

  private String roomId;
  private String name;
  private Set<WebSocketSession> sessions = new HashSet<>();

  @Builder
  public ChatRoom(String roomId, String name) {
    this.roomId = roomId;
    this.name = name;
  }

  public void handleAction(WebSocketSession session, ChatDTO message, ChatService service) {
    // message에 담긴 타입을 확인
    // 이때 message에서 getType으로 가져온 내용이 ChatDTO의 열거형인 MessageType 안에 있는 ENTER와 동일합 값일 경우
    if (message.getClass().equals(MessageType.ENTER)) {
      // session에는 넘어온 session을 담는다
      sessions.add(session);

      // message에는 입장했다는 메시지를 띄운다.
      message.
    }
  }
}
