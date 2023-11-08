package com.project.graphqldemoproject.service;

import com.project.graphqldemoproject.exception.InvalidPanelException;
import com.project.graphqldemoproject.exception.PanelNotFoundException;
import com.project.graphqldemoproject.model.Panel;
import com.project.graphqldemoproject.model.PanelType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PanelServiceImpl implements PanelService{

    private List<Panel> panels=new ArrayList<>();

    AtomicInteger id=new AtomicInteger(0);


    @Override
    public List<Panel> findAll() {
        return panels;
    }

    @Override
    public Optional<Panel> findById(Integer id) {
        return Optional.of(panels.stream()
                .filter(panel -> Objects.equals(panel.id(),id))
                .findFirst()
                .orElseThrow(()->new PanelNotFoundException("Panel Not Found")));
    }



    @Override
    public Panel create(String brandName, PanelType panelType) {
        Panel panel=new Panel(id.incrementAndGet(),brandName,panelType);
        panels.add(panel);
        return panel;
    }

    @Override
    public Panel update(Integer id, String brandName, PanelType panelType) {
       Panel updatedPanel=new Panel(id,brandName,panelType);
       Optional<Panel> optionalPanel=panels.stream()
               .filter(panel2 -> Objects.equals(panel2.id(),id))
               .findFirst();
        if (optionalPanel.isPresent()) {
            Panel panel=optionalPanel.get();
            int index=panels.indexOf(panel);
            panels.set(index,updatedPanel);
        }
        else{
            throw new InvalidPanelException("Invalid panel");
        }
        return updatedPanel;
    }

    @Override
    public Panel deleteById(Integer id) {
        Panel panel=panels.stream()
                .filter(panel3->Objects.equals(panel3.id(),id))
                .findFirst()
                .orElseThrow(()->new PanelNotFoundException("Panel Not Found"));
        panels.remove(panel);
        return panel;
    }

    @PostConstruct
    public void initialize(){
        panels.add(new Panel(id.incrementAndGet(),"SAMSUNG",PanelType.IPS));
        panels.add(new Panel(id.incrementAndGet(),"MSI",PanelType.VA));
        panels.add(new Panel(id.incrementAndGet(),"LG",PanelType.TN));
    }
}
