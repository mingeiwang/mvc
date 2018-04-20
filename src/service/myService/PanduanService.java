package service.myService;

import java.util.List;
import java.util.Map;

import service.vo.MessageVO;

public interface PanduanService {

	Map<String, MessageVO> getVO(String user);
}
