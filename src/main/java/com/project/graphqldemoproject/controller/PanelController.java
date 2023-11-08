package com.project.graphqldemoproject.controller;

import com.project.graphqldemoproject.model.Panel;
import com.project.graphqldemoproject.model.PanelType;
import com.project.graphqldemoproject.service.PanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PanelController {
    private final PanelService panelService;

    @QueryMapping
    public List<Panel> findAll(){
        return panelService.findAll();
    }

    @QueryMapping
    public Optional<Panel> findById(@Argument Integer id){
        return panelService.findById(id);
    }

    @MutationMapping
    public Panel create(@Argument String brandName,@Argument PanelType panelType){
        return panelService.create(brandName,panelType);
    }

    @MutationMapping
    public Panel update(@Argument Integer id,@Argument String brandName,@Argument PanelType panelType){
        return panelService.update(id,brandName,panelType);
    }

    @MutationMapping
    public Panel deleteById(@Argument Integer id){
        return panelService.deleteById(id);
    }




}
