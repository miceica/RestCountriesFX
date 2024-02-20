package com.ceica.restcountriesfx;

import com.ceica.restcountriesfx.models.CountryDTO;
import com.ceica.restcountriesfx.services.FakeRestCountriesService;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;

public class RestCountriesController {
    @FXML
    protected ComboBox comboRegions;
    @FXML
    protected TableView<CountryDTO> tblCountries;
    @FXML
    protected TableColumn<CountryDTO, String> columCountryName;
    @FXML
    protected ImageView imgFlag;
    @FXML
    protected TextField txtCountryName;
    @FXML
    protected TextField txtCountryCoin;
    @FXML
    protected TextField txtCountryPopulation;
    @FXML
    protected TextField txtCountryCapital;

    private ObservableList<CountryDTO> observableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        FakeRestCountriesService fakeRestCountriesService = new FakeRestCountriesService();
        comboRegions.getItems().addAll(fakeRestCountriesService.getRegions());
        comboRegions.setOnAction(e -> {
            if (comboRegions.getSelectionModel().getSelectedItem() != null) {
                String region = comboRegions.getSelectionModel().getSelectedItem().toString();
                observableList.clear();
                observableList.addAll(fakeRestCountriesService.getCountriesByRegion(region));
                tblCountries.setItems(observableList);
            }
        });
        tblCountries.setOnMouseClicked(e -> {
            String countryName = tblCountries.getSelectionModel().getSelectedItem().getName();
            CountryDTO countryDTO = fakeRestCountriesService.getCountriesByName(countryName);
            txtCountryCapital.setText(countryDTO.getCapital());
            txtCountryName.setText(countryDTO.getName());
            txtCountryCoin.setText(countryDTO.getCoin());
            txtCountryPopulation.setText(String.valueOf((countryDTO.getPopulation())));
            Image image = new Image(countryDTO.getFlag());
            imgFlag.setImage(image);
        });

        columCountryName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
    }

    @FXML
    public void btnClear(ActionEvent actionEvent) {
        observableList.clear();
        tblCountries.refresh();
        comboRegions.getSelectionModel().clearSelection();
        txtCountryCapital.clear();
        txtCountryName.clear();
        txtCountryCoin.clear();
        txtCountryPopulation.clear();
        imgFlag.setImage(null);
    }
}