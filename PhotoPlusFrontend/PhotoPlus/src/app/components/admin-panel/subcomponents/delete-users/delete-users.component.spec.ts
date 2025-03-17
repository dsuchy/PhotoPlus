import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DeleteUsersComponent } from './delete-users.component';

describe('DeleteUsersComponent', () => {
  let component: DeleteUsersComponent;
  let fixture: ComponentFixture<DeleteUsersComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
