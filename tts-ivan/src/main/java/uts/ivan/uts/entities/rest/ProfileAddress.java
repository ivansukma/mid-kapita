/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.ivan.uts.entities.rest;

import lombok.Data;

/**
 *
 * @author ivanr
 */
@Data
public class ProfileAddress {
    private String city;
    private String id;
    private String province;
    private String street1;
    private String street2;
    private String zipCode;
}
