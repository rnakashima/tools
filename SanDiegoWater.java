/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandiegowaterways;

/**
 *
 * @author RPTA_Research
 */
public enum SanDiegoWater {
    AGUA_HEDIONDIA_LAGOON (59),
    BARRETT_LAKE (60),
    CUYAMACA_LAKE (61),
    EL_CAPITAN_LAKE (62),
    HODGES_RESERVOIR (63),
    LAKE_DIXON (64),
    LAKE_HENSHAW (65),
    LAKE_JENNINGS (66),
    LAKE_MIRAMAR (67),
    LAKE_MORENA (68),
    LAKE_POWAY (69),
    LAKE_WOHLFORD (70),
    MISSION_BAY (71),
    MURRAY_RESERVOIR (72),
    OCEANSIDE_HARBOR (73),
    OTAY_LAKE (74),
    PACIFIC_OCEAN (75),
    SAN_DIEGO_BAY (76),
    SAN_VICENTE_RESERVOIR (77),
    SANTEE_LAKES (78),
    SHELTER_ISLAND_YACHT_BASIN (79),
    SUTHERLAND_RESRVOIR (80),
    OTHER (38);
    
    private final int value;
    
    SanDiegoWater(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
