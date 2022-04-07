package hr.tvz.miholic.hardwareapp.Service;

import hr.tvz.miholic.hardwareapp.Classes.HardwareDTO;
import hr.tvz.miholic.hardwareapp.Commands.HardwareCommand;

import java.util.List;
import java.util.Optional;

public interface HardwareService {
    List<HardwareDTO> findAll();
    /*
    HardwareDTO findByCode(String code);
    */

    List<HardwareDTO> findByType(String type);

    Optional<HardwareDTO> save(HardwareCommand command);

    Optional<HardwareDTO> delete(String code);

    Optional<HardwareDTO> getByCode(String code);

    Optional<HardwareDTO> update(String code, HardwareCommand updateHardwareCommand);
}
