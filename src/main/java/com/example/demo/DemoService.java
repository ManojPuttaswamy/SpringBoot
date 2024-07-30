package com.example.demo;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private List<DemoReturnAJSONObj> returnAJSONObjects = new ArrayList<>(
            Arrays.asList(new DemoReturnAJSONObj(1, "Demo", "This is a demo JSON object."),
                    new DemoReturnAJSONObj(2, "Demo2", "This is a demo JSON object2."),
                    new DemoReturnAJSONObj(3, "Demo3", "This is a demo JSON object3.")));

    public List<DemoReturnAJSONObj> getAllObjects() {
        return returnAJSONObjects;
    }

    public DemoReturnAJSONObj getObj(int id) {
        return returnAJSONObjects.stream().filter(obj -> obj.getId() == id).findFirst().get();
    }

    public void addObj(DemoReturnAJSONObj body) {
        returnAJSONObjects.add(body);
    }

    public void updateObj(int id, DemoReturnAJSONObj entity) {
        for (DemoReturnAJSONObj key : returnAJSONObjects) {
            if (key.getId() == id) {
                key.setName(entity.getName());
                key.setDescription(entity.getDescription());
                return;
            }
            
        }
    }

    public void deleteObj(int id) {
        returnAJSONObjects.removeIf(obj -> obj.getId() == id);
    }

    public void partialUpdateObj(int id, DemoReturnAJSONObj body) {
        for (DemoReturnAJSONObj Obj : returnAJSONObjects) {
            if(Obj.getId() == id){
                if(body.getName()!= null){
                    Obj.setName(body.getName());
                }
                if(body.getDescription()!= null){
                    Obj.setDescription(body.getDescription());
                }
                return;
            }
        }
    }
}
