package org.zhxie.sprintpoker.entity.game;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class RoomGameRecord {

  private List<SingleGameRecord> recordList = Lists.newArrayList(new SingleGameRecord());
  private String roomName = "";

  public int getTotalGameRecord() {
    return recordList.size();
  }

  public void addSingleGameRecord() {
    recordList.add(new SingleGameRecord());
  }

  public SingleGameRecord getCurPage(int selectedGameIndex) {
    if (selectedGameIndex <0 || selectedGameIndex > recordList.size()) {
      throw new UnsupportedOperationException("Error Index");
    }
    return recordList.get(selectedGameIndex - 1);
  }


  public void removePlayer(String exitUserId) {
    for(SingleGameRecord record : recordList) {
      record.removeScoreRecord(exitUserId);
    }
  }

  public void resetPage(int selectedGameIndex) {
    if (selectedGameIndex <0 || selectedGameIndex > recordList.size()) {
      throw new UnsupportedOperationException("Error Index");
    }
    recordList.set(selectedGameIndex - 1, new SingleGameRecord());
  }

  public void addScoreRecord(String playerName, String roomName) {
    for (SingleGameRecord record : recordList) {
      record.addScoreRecord(playerName, roomName);
    }
  }

  public void addStory() {
    recordList.add(new SingleGameRecord());
  }
}
