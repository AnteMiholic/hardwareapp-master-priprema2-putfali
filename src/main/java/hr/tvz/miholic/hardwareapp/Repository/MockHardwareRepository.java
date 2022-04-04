package hr.tvz.miholic.hardwareapp.Repository;

import hr.tvz.miholic.hardwareapp.Classes.Hardware;
import hr.tvz.miholic.hardwareapp.Enums.HardwareTypeEnum;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MockHardwareRepository implements HardwareRepository {

    private final List<Hardware> MOCKED_HARDWARE = new ArrayList<>(
            Arrays.asList(
                    new Hardware("i5 9500", "123456789", 2000.55, HardwareTypeEnum.CPU, 5),
                    new Hardware("Nvidia GeForce GTX 1650 OC", "123123123231321", 10000.99, HardwareTypeEnum.GPU, 0),
                    new Hardware("Nvidia GeForce RTX 3090", "3222222", 100000, HardwareTypeEnum.GPU, 0),
                    new Hardware("Genious MK-500", "746453", 20, HardwareTypeEnum.OTHER, 250),
                    new Hardware("Genious MK-500 Mechanical", "746453", 100.05, HardwareTypeEnum.OTHER, 20)

            )
    );

    @Override
    public Optional<Hardware> save(Hardware hardware) {
        String code = hardware.getCode();
        System.out.println(hardware);
        if(!MOCKED_HARDWARE.stream().anyMatch(e -> e.getCode().equals(code))){
            MOCKED_HARDWARE.add(hardware);
            return Optional.of(hardware);
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public List<Hardware> findAll() {
        return MOCKED_HARDWARE;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return MOCKED_HARDWARE.stream().filter(it -> Objects.equals(it.getCode(), code)).findAny();
    }
    @Override
    public List<Hardware> findByType(String type) {
        return MOCKED_HARDWARE.stream().filter(it -> Objects.equals(it.getType(), HardwareTypeEnum.valueOf(type))).collect(Collectors.toList());
    }

    @Override
    public Optional<Object> delete(String code) {
        System.out.println("Prije ifa");
        if(MOCKED_HARDWARE.stream().anyMatch(e -> e.getCode().equals(code))){
            System.out.println("poslije ifa");
            MOCKED_HARDWARE.removeIf(it -> Objects.equals(it.getCode(), code));
            return Optional.of(code);
        }
        else
            return Optional.empty();

    }

}
