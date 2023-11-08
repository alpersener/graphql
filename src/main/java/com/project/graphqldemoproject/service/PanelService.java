package com.project.graphqldemoproject.service;

import com.project.graphqldemoproject.model.Panel;
import com.project.graphqldemoproject.model.PanelType;

import java.util.List;
import java.util.Optional;

public interface PanelService {

    List<Panel> findAll();
    Optional<Panel> findById(Integer id);

    Panel create(String brandName, PanelType panelType);

    Panel update(Integer id,String brandName, PanelType panelType);

    Panel deleteById(Integer id);

}
