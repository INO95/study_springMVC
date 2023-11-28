package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

/**
 * description :
 * fileName    : ControllerV3
 * author      : ino
 * since       : 2023-11-28
 */
public interface ControllerV3 {

  ModelView process(Map<String, String> paramMap);
}
