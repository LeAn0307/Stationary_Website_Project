package com.shinhands.mu.Stationary.controller;

import com.shinhands.mu.Stationary.dto.BillDTO;
import com.shinhands.mu.Stationary.service.BillDetailService;
import com.shinhands.mu.Stationary.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private BillDetailService billDetailService;

    @GetMapping("")
    public ResponseEntity<List<BillDTO>> getAllBills() {
        try {
            List<BillDTO> billDTO = billService.getAllBills();
            if(billDTO.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(billDTO ,HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillDTO> getBillById(@PathVariable long id) {
        try {
            BillDTO billDTO = billService.getBillsByBillId(id);
            if(billDTO == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(billDTO ,HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byDate")
    public ResponseEntity<List<BillDTO>> getBillByDateOrder(@RequestParam String orderDate) {
        try {
            Date newDate = new SimpleDateFormat("dd/MM/yyyy").parse(orderDate);
            List<BillDTO> billDTO = billService.getBillsByOrderDate(newDate);
            if(billDTO.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(billDTO ,HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity createBill(@RequestBody BillDTO billDTO) {
        try {
            long billId = billService.addBill(billDTO);
            if(billDetailService.addBillDetail(billId ,billDTO.getBillDetailDTOList())){
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillDTO> updateBill(@PathVariable long id, @RequestBody BillDTO billDTO) {
        try {
            return new ResponseEntity<>(billService.updateBill(id ,billDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBill(@PathVariable long id) {
       try {
           long result = billService.deleteBill(id);
           return ResponseEntity.ok().body(result);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
